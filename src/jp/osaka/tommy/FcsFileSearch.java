package jp.osaka.tommy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FcsFileSearch {

	/* 検索するSAVEボタン名（複数）を保持する */
	private ArrayList<String> saveButtonList = new ArrayList<String>();
	private static final String DISPID = "DISPID";
	private static final String DISPID_REGEX = "F[\\d\\-]+[^\"]";


	public void search(FcsFile fcsf) {

		File file = new File(fcsf.getPathName());
		FileReader filereader = null;
		BufferedReader br = null;

		try {
			filereader = new FileReader(file);
			br = new BufferedReader(filereader);

			searchDetail(br, fcsf);

			br.close();
			filereader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private void searchDetail(BufferedReader br, FcsFile fcsf) throws IOException {

		// private Boolean hasSaveButton = false;
		// SAVEボタンの名称
		// private String saveButtonName = "";

		// SAVEメソッド
		// private String saveMethod = "";
		// SAVEメソッドで呼ばれるActionId
		// private String saveActionId = "";

		// 画面ＩＤ
		// private String dispId = "";
		// 画面名に紐づくT_WORD_MST.WORD_ID
		// private String dispWordId = "";

		String line;
		while((line = br.readLine()) != null){

			int index = -1;

			// SAVEボタンがあるか
			for (String btn : this.saveButtonList) {
				index = line.indexOf(btn);
				if (index > -1) {
					fcsf.setHasSaveButton(true);
					fcsf.setSaveButtonName(fcsf.getSaveButtonName() + btn);

					// SAVEメソッドで呼ばれるActionId


				}
			}

			// 画面ＩＤがあるか
			index = line.indexOf(DISPID);
			if (index > -1) {
				Pattern p = Pattern.compile(DISPID_REGEX);
				Matcher m = p.matcher(line);
				if (m.find()){
					fcsf.setDispId(fcsf.getDispId() + m.group());
				}
			}

			// 画面名に紐づくT_WORD_MST.WORD_ID


			System.out.println(line);
		}

	}

	public ArrayList<String> getSaveButtonList() {
		return saveButtonList;
	}

	public void setSaveButtonList(ArrayList<String> saveButtonList) {
		this.saveButtonList = saveButtonList;
	}

}
