package com.xm.chess.service.moveservice;

import java.util.LinkedList;

import com.xm.chess.domain.Knight;
import com.xm.chess.domain.Piece;
import com.xm.chess.domain.Position;


public class KnightAllowedMove implements AllowedMoves<Knight>{

	/**
	 * For x, y coordinates will get allowed neighbor coordinates
	 * For x=row and y=col the formula of allowed positions will be
	 * Left allowed
	 * x-2, y-1
	 * x-1, y-2
	 * x+1, y-2
	 * x+2, y-1
	 * Right allowed
	 * x-2, y+1
	 * x-1, y+2
	 * x+1, y+2
	 * x+2, y+1
	 */
	@Override
	public LinkedList<Position> getAllowsMoves(Piece piece, Position position) {
		LinkedList<Position> response = new LinkedList<>();
		int row = position.getX();
		int col = position.getY();
		if(row-2>=0 && col-1>=0)response.add(new Position(row-2, col-1));
		if(row-1>=0 && col-2>=0)response.add(new Position(row-1, col-2));
		if(row+1>=0 && col-2>=0)response.add(new Position(row+1, col-2));
		if(row+2>=0 && col-1>=0)response.add(new Position(row+2, col-1));
		
		if(row-2>=0 && col+1>=0)response.add(new Position(row-2, col+1));
		if(row-1>=0 && col+2>=0)response.add(new Position(row-1, col+2));
		if(row+1>=0 && col+2>=0)response.add(new Position(row+1, col+2));
		if(row+2>=0 && col+1>=0)response.add(new Position(row+2, col+1));
		return response;
	}

}
