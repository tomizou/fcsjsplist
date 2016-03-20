package jp.osaka.tommy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Focus全JSP情報を取得
 * @author Tommy
 *
 */
public class App {

	public static void main(String[] args) {

		String readDir = "D:\\JavaWork\\Spring4test";
		String writeFile = "D:\\Output.txt";
		String readExt = ".xml";
		ArrayList<String> saveButtonList = new ArrayList<String>();
		Collections.addAll(saveButtonList, "showWarnings", "org.apache.log4j.PatternLayout");


		DirectoryReader reader = new DirectoryReader();

		// ファイルリスト読み込み開始
		int cnt = reader.read(readDir, readExt);
		System.out.println(String.valueOf(cnt));

		if (cnt > 0) {
			ArrayList<FcsFile> fcsFileList = new ArrayList<FcsFile>();
			fcsFileList = reader.getFcsFileList();

			System.out.println(String.valueOf(fcsFileList.size()));


			// ファイル解析
			FcsFileSearch ffs = new FcsFileSearch();
			ffs.setSaveButtonList(saveButtonList);

			for(FcsFile ff : fcsFileList) {
				ffs.search(ff);
			}



			// ファイル出力
			FcsFileWriter ffw = new FcsFileWriter();
			try {
				ffw.write(fcsFileList, writeFile);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
