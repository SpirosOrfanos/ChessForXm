package com.xm.chess.service.boardservice;

import java.util.*;

import com.xm.chess.domain.Piece;
import com.xm.chess.domain.Position;

public interface ChessInterface {

	public LinkedList<Position> getAllowedMoves(Piece piece, Position position);
	public int calculatePath(Position start, Position end);
}
