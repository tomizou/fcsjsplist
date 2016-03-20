package jp.osaka.tommy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FcsFileWriter {

	/**
	 * 取得リスト書き出し
	 * @param fcsFileList 取得リスト
	 * @param writeFile 出力パスファイル名
	 * @throws Exception
	 */
	public void write(ArrayList<FcsFile> fcsFileList, String writeFile) throws Exception {

		File file = new File(writeFile);
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(filewriter);

		for (FcsFile ff : fcsFileList) {
			writeLine(bw, ff);
		}

		bw.close();

	}

	private void writeLine(BufferedWriter bw, FcsFile ff) throws Exception {
		bw.write(ff.getPathName());
		bw.write("\t");
		bw.write(ff.getFileName());
		bw.write("\t");
		bw.write(ff.getSaveButtonName());
		bw.write("\t");
		bw.write(ff.getSaveMethod());
		bw.write("\t");
		bw.write(ff.getSaveActionId());
		bw.write("\t");
		bw.write(ff.getDispId());
		bw.write("\t");
		bw.write(ff.getDispWordId());
		bw.write("\t");
		bw.write(ff.getDispName());
		bw.write("\t");
		bw.write(ff.getDispNameJp());
		bw.newLine();
	}
}
