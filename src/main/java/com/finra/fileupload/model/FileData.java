package com.finra.fileupload.model;
	
public class FileData {

	private long id;
	
	private String fileName;
	
	private int fileSize;
	
	private String fileDescription;

	public FileData(){
		id=0;
	}
	
	public FileData(long id, String fileName, int fileSize, String fileDescription){
		this.id = id;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileDescription = fileDescription;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileData other = (FileData) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fileName=" + fileName + ", fileSize=" + fileSize
				+ ", fileDescription=" + fileDescription + "]";
	}
}
