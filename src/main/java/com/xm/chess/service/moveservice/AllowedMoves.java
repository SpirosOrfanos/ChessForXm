package com.xm.chess.service.moveservice;

import java.util.LinkedList;

import com.xm.chess.domain.Piece;
import com.xm.chess.domain.Position;


public interface AllowedMoves<T extends Piece>{
	LinkedList<Position> getAllowsMoves(Piece piece, Position position);
}
