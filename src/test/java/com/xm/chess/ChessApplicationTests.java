package com.xm.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.xm.chess.domain.Position;
import com.xm.chess.execptions.BoardInitException;
import com.xm.chess.service.boardservice.Board;
import com.xm.chess.service.boardservice.ChessBoard;
import com.xm.chess.service.moveservice.AllowedMovesFactory;

@RunWith(SpringRunner.class)
public class ChessApplicationTests {

	@Test(expected=BoardInitException.class)
	public void testInvalidBoardIitialize() throws Exception{
		Board board = new ChessBoard(0, 0, null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNoStrategy() throws Exception{
		Board board = new ChessBoard(8, 8, null);
	}

	@Test()
	public void testMovesOneNext() throws Exception{
		ChessBoard board = new ChessBoard(8, 8, new AllowedMovesFactory());
		assertEquals(1, board.calculatePath(new Position(0, 0), new Position(2, 1)));
	}
	@Test()
	public void testMovesAway() throws Exception{
		ChessBoard board = new ChessBoard(8, 8, new AllowedMovesFactory());
		assertEquals(2, board.calculatePath(new Position(0, 0), new Position(0, 2)));
	}
	@Test()
	public void testMovesAwayWithMin() throws Exception{
		ChessBoard board = new ChessBoard(8, 8, new AllowedMovesFactory());
		assertEquals(2, board.calculatePath(new Position(0, 0), new Position(3, 3)));
	}
	
}
