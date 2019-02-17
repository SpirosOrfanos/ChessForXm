package com.xm.chess.service.boardservice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.xm.chess.domain.Position;
import com.xm.chess.execptions.BoardInitException;
import com.xm.chess.service.moveservice.AllowedMovesFactory;


/**
 * 
 * @author sorfanos
 *
 */
public abstract class Board {
	int ROWS;
	int COLUMNS;
	Position[] positions;
	Map<Position, Integer> positionMapping;
	int [][] board;
	/*This is used for knights adjustment*/
	LinkedList<Position>[] adjustment;
	AllowedMovesFactory allowedMovesFactory;
	
	/**
	 * 
	 * @param ROWS
	 * @param COLUMNS
	 * @param allowedMovesFactory "fake service"
	 * @throws BoardInitException
	 */
	public Board(int ROWS, int COLUMNS, AllowedMovesFactory allowedMovesFactory) throws BoardInitException{
		if(ROWS<=0 || COLUMNS<=0) throw new BoardInitException("Invalid board size");
		this.ROWS = ROWS;
		this.COLUMNS = COLUMNS;
		positionMapping  = new HashMap<>();
		this.positions = new Position[ROWS*COLUMNS];
		this.board = new int[ROWS][COLUMNS];
		adjustment = new LinkedList[ROWS*COLUMNS];
		this.allowedMovesFactory = allowedMovesFactory;
		init();
	}


	private void init() {
		initBoard();
	}
	abstract void initBoard();

}
