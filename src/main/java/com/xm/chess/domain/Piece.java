package com.xm.chess.domain;
/**
 * 
 * @author sorfanos
 *
 */
public class Piece {
	Position position;
	PieceType pieceType;
	public int dist;
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public PieceType getPieceType() {
		return pieceType;
	}
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
}
