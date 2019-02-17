package com.xm.chess.domain;
/**
 * 
 * @author sorfanos
 * Available chess pieces
 *  1 king
 *	1 queen
 *	2 rooks
 *	2 bishops
 *	2 knights
 *	8 pawns
 */
public enum PieceType {
	KING(1), QUEEN(1), ROOK(2), BISHOP(2), KNIGHT(2), PAWN(8);
	private int max;
	private PieceType(int max) {
		this.max = max;
	}
	public int getMax() {
		return max;
	}
	
}
