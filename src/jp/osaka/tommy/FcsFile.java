package jp.osaka.tommy;

public class FcsFile {
	/* path + filename */
	private String pathName = "";
	/* filename */
	private String fileName = "";
	/* SAVEボタンがあるか */
	private Boolean hasSaveButton = false;
	/* SAVEボタンの名称 */
	private String saveButtonName = "";
	/* SAVEメソッド */
	private String saveMethod = "";
	/* SAVEメソッドで呼ばれるActionId */
	private String saveActionId = "";
	/* 画面ＩＤ */
	private String dispId = "";
	/* 画面名に紐づくT_WORD_MST.WORD_ID */
	private String dispWordId = "";
	/* 画面名 */
	private String dispName = "";
	/* 画面名日本語 */
	private String dispNameJp = "";


	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Boolean getHasSaveButton() {
		return hasSaveButton;
	}
	public void setHasSaveButton(Boolean hasSaveButton) {
		this.hasSaveButton = hasSaveButton;
	}
	public String getSaveButtonName() {
		return saveButtonName;
	}
	public void setSaveButtonName(String saveButtonName) {
		this.saveButtonName = saveButtonName;
	}
	public String getSaveMethod() {
		return saveMethod;
	}
	public void setSaveMethod(String saveMethod) {
		this.saveMethod = saveMethod;
	}
	public String getSaveActionId() {
		return saveActionId;
	}
	public void setSaveActionId(String saveActionId) {
		this.saveActionId = saveActionId;
	}
	public String getDispId() {
		return dispId;
	}
	public void setDispId(String dispId) {
		this.dispId = dispId;
	}
	public String getDispWordId() {
		return dispWordId;
	}
	public void setDispWordId(String dispWordId) {
		this.dispWordId = dispWordId;
	}
	public String getDispName() {
		return dispName;
	}
	public void setDispName(String dispName) {
		this.dispName = dispName;
	}
	public String getDispNameJp() {
		return dispNameJp;
	}
	public void setDispNameJp(String dispNameJp) {
		this.dispNameJp = dispNameJp;
	}

}
