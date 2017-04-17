package com.scyllabase;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PageHeader {

	private long pageStartFP;
	private byte pageType;
	private byte numCells;
	private short cellContentStartOffset;
	private int rightChiSibPointer;
	private List<Short> cellLocations;
	private short headerEndOffset;

	public PageHeader(RandomAccessFile file, int pageNumber) {
		this.pageStartFP = pageNumber * UtilityTools.pageSize;
		try {
			file.seek(this.pageStartFP);
			this.pageType = file.readByte();

			this.numCells = file.readByte();
			this.cellContentStartOffset = file.readShort();
			this.rightChiSibPointer = file.readInt();
			for (int i = 0; i < this.numCells; i++)
				this.cellLocations.add(file.readShort());
			this.headerEndOffset = (short) (file.getFilePointer() - pageStartFP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte getPageType() {
		return this.pageType;
	}

	public short getCellContentStartOffset() {
		return this.cellContentStartOffset;
	}

	public int getRightChiSibPointer() {
		return this.rightChiSibPointer;
	}

	public List<Short> getCellLocations() {
		return this.cellLocations;
	}

	public byte getNumCells() {
		return numCells;
	}

	public long getPageStartFP() {
		return pageStartFP;
	}

	public short getHeaderEndOffset() {
		return headerEndOffset;
	}
}
