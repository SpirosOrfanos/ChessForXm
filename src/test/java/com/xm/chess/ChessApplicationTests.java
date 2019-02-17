package com.xm.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xm.chess.domain.Position;
import com.xm.chess.execptions.BoardInitException;
import com.xm.chess.service.boardservice.Board;
import com.xm.chess.service.boardservice.ChessBoard;
import com.xm.chess.service.moveservice.AllowedMovesFactory;

@RunWith(JUnit4.class)
public class ChessApplicationTests {
	private Logger logger = LoggerFactory.getLogger(ChessApplicationTests.class);
	@Test(expected=BoardInitException.class)
	public void testInvalidBoardIitialize() throws Exception{
		logger.info("testInvalidBoardIitialize");
		Board board = new ChessBoard(2, 2, null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNoStrategy() throws Exception{
		logger.info("testNoStrategy");
		Board board = new ChessBoard(8, 8, null);
	}

	@Test()
	public void testMovesOneNext() throws Exception{
		logger.info("testMovesOneNext");
		ChessBoard board = new ChessBoard(8, 8, new AllowedMovesFactory());
		assertEquals(1, board.calculatePath(new Position(0, 0), new Position(2, 1)));
	}
	@Test()
	public void testMovesAway() throws Exception{
		logger.info("testMovesAway");
		ChessBoard board = new ChessBoard(8, 8, new AllowedMovesFactory());
		assertEquals(2, board.calculatePath(new Position(0, 0), new Position(0, 2)));
	}
	@Test()
	public void testMovesAwayWithMin() throws Exception{
		logger.info("testMovesAwayWithMin");
		ChessBoard board = new ChessBoard(8, 8, new AllowedMovesFactory());
		assertEquals(2, board.calculatePath(new Position(2, 2), new Position(5, 3)));
	}
	
}
