package com.xm.chess.service.moveservice;

import java.util.*;

import com.xm.chess.domain.Piece;
import com.xm.chess.domain.Position;

public class AllowedMoveContext {

	
	private AllowedMoves allowedMoves;

	public AllowedMoveContext(AllowedMoves allowedMoves) {
		this.allowedMoves = allowedMoves;
	}
	
	public LinkedList<Position> execute(Piece piece, Position position) {
		return this.allowedMoves.getAllowsMoves(piece, position);
	}
	
}
