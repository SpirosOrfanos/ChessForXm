package com.xm.chess.service.moveservice;

import com.xm.chess.domain.Knight;
import com.xm.chess.domain.Piece;


public class AllowedMovesFactory {
	public AllowedMoveContext getAllowedMovesContext(Piece piece) {
		if(piece instanceof Knight)
			return new AllowedMoveContext(new KnightAllowedMove());
		return null;
			
	}

}
