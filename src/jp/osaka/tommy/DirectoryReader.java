package jp.osaka.tommy;

import java.io.File;
import java.util.ArrayList;

public class DirectoryReader {

	/* 取得したファイルを格納する */
	private ArrayList<FcsFile> fcsFileList = new ArrayList<FcsFile>();

	/**
	 * 読み込み対象ディレクトリ以下のファイルを全て取得する
	 * @param readDir 読み込み対象ディレクトリ
	 * @param readFileExtension 読み込み対象拡張子
	 * @return 取得したファイルリスト
	 */
	public int read(String readDir, String readFileExtension) {
		this.fcsFileList = new ArrayList<FcsFile>();

		read(new File(readDir), readFileExtension);

		return fcsFileList.size();
	}

	/**
	 * ディレクトリ読み込み
	 * @param readDir 読み込み対象ディレクトリ
	 * @param readFileExtension 読み込み対象拡張子
	 */
	private void read(File dir, String readFileExtension) {

		File[] files = dir.listFiles();

		if(files == null)
			return;

		for(File file : files) {
			if(!file.exists()) {
				continue;

			} else if(file.isDirectory()) {
				read(file, readFileExtension);

			} else if(file.isFile()) {
				if (!readFileExtension.equals("")) {
					if(file.getName().lastIndexOf(readFileExtension) > -1) {
						addFile(file);
					}
				}
			}
		}
	}

	/**
	 * ファイルをリストに追加
	 * @param filePath
	 */
	private void addFile(File file) {
		System.out.println(file.getPath());

		FcsFile fcsf = new FcsFile();
		fcsf.setPathName(file.getPath());
		fcsf.setFileName(file.getName());
		fcsFileList.add(fcsf);
	}

	public ArrayList<FcsFile> getFcsFileList() {
		return fcsFileList;
	}

}
