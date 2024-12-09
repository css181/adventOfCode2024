package day9;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day9 {

	private static File file;
	private ArrayList<Block> blockList = new ArrayList<Block>();
	int blockIndex;
	int arrayIndexInBlock;

	public Day9() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
		blockIndex = blockList.size()-1;
		arrayIndexInBlock = blockList.get(blockIndex).getValues().size()-1;
	}
	public Day9(File file) {
		blockList = new ArrayList<Block>();
		setFileToUse(file);
		populateInput();
		blockIndex = blockList.size()-1;
		arrayIndexInBlock = blockList.get(blockIndex).getValues().size()-1;
	}

	protected void setFileToUse(File file) {
		Day9.file = file;
	}

	public void populateInput() {
		String input = FileUtility.convertFileToString(file);
		ArrayList<Integer> inputNums = new ArrayList<Integer>();
		for (Character number : input.toCharArray()) {
			inputNums.add(Integer.valueOf(String.valueOf(number)));
		}
		int id=0;
		Block curBlock;
		for (int index=0; index<inputNums.size(); index++) {
			int num = inputNums.get(index);
			if(index%2==0) {
				ArrayList<Integer> blockNums = new ArrayList<Integer>();
				for(int x=0; x<num; x++) {
					blockNums.add(id);
				}
				curBlock = new Block(blockNums, 0);
				id++;
			} else {
				ArrayList<Integer> blockNums = new ArrayList<Integer>();
				curBlock = new Block(blockNums, num);
			}
			blockList.add(curBlock);
		}
	}
	
	public ArrayList<Block> getBlockList() {
		return blockList;
	}
	
	public ArrayList<Integer> sortBlocks() {
		ArrayList<Integer> sortedBlocks = new ArrayList<Integer>();
		for (int curBlockIndex=0; curBlockIndex<blockList.size(); curBlockIndex++) {
			Block block = blockList.get(curBlockIndex);
			if(curBlockIndex>=blockIndex) {
				//we got to the block we're pulling from, so just add whatever is remaining and stop
				sortedBlocks.addAll(block.getValues());
				break;
			}
			if(block.getFreeSlots()==0) {
				sortedBlocks.addAll(block.getValues());
			}
			else {
				sortedBlocks.addAll(getNext_x_Numbers_from_back_of_BlockList(block.getFreeSlots()));
			}
			
		}
		return sortedBlocks;
	}
	
	private ArrayList<Integer> getNext_x_Numbers_from_back_of_BlockList(int slotsNeeded) {
		ArrayList<Integer> newInts = new ArrayList<Integer>();
		
		do {
			Block curBlock = blockList.get(blockIndex);
			while(arrayIndexInBlock<0) {
				blockIndex--;
				curBlock = blockList.get(blockIndex);
				arrayIndexInBlock = curBlock.getValues().size()-1;
			}
			newInts.add(curBlock.getValues().get(arrayIndexInBlock));
			//remove it from the blockList to "free" up the space from that block, and decrement index
			curBlock.getValues().remove(arrayIndexInBlock--);
			curBlock.getSetFreeSlots(curBlock.getFreeSlots()+1);
		} while (newInts.size()<slotsNeeded);
		
		return newInts;
	}
	
	public Long getChecksumOfSortedBlocks() {
		long total = 0;
		ArrayList<Integer> sortBlocks = sortBlocks();
		for (int x=0; x<sortBlocks.size(); x++) {
			total+= x * sortBlocks.get(x);
		}
		
		return total;
	}
	
	
	public ArrayList<Integer> sortBlocksKeepingFilesTogether() {
		ArrayList<Integer> sortedBlocks = new ArrayList<Integer>();
		for (int curBlockIndex=blockList.size()-1; curBlockIndex>0; curBlockIndex--) {
			Block curBlock = blockList.get(curBlockIndex);
			if(curBlock.getValues().size()>0) {				
				for (int tryIndex=0; tryIndex<curBlockIndex; tryIndex++) {
					Block tryMoveToBlock = blockList.get(tryIndex);
					if(tryMoveToBlock.getFreeSlots()>= curBlock.getValues().size()) {
						//it fits, so move it there
						tryMoveToBlock.getValues().addAll(curBlock.getValues());
						tryMoveToBlock.getSetFreeSlots(tryMoveToBlock.getFreeSlots() - curBlock.getValues().size());
						curBlock.getSetFreeSlots(Integer.valueOf(curBlock.getValues().size()));
						curBlock.setValues(new ArrayList<Integer>());
						break;
					}
				}
			}
		}
		
		for (Block block : blockList) {
			sortedBlocks.addAll(block.getValues());
			if(block.getFreeSlots()>0) {
				for(int x=0; x<block.getFreeSlots(); x++) {
					sortedBlocks.add(0);
				}
			}
		}
		return sortedBlocks;
	}
	public Long getChecksumOfSortedBlocksByFullFiles() {
		long total = 0;
		ArrayList<Integer> sortBlocks = sortBlocksKeepingFilesTogether();
		for (int x=0; x<sortBlocks.size(); x++) {
			total+= x * sortBlocks.get(x);
		}
		
		return total;
	}
	
}
