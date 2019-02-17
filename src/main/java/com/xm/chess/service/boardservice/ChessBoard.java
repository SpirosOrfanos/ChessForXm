package com.xm.chess.service.boardservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

import com.xm.chess.domain.Knight;
import com.xm.chess.domain.Node;
import com.xm.chess.domain.Piece;
import com.xm.chess.domain.Position;
import com.xm.chess.execptions.BoardInitException;
import com.xm.chess.service.moveservice.AllowedMovesFactory;

/**
 * 
 * @author sorfanos
 *
 */
public class ChessBoard extends Board implements ChessInterface {
	private int count;

	public ChessBoard(int rows, int columns, AllowedMovesFactory allowedMovesFactory) throws BoardInitException {
		super(rows, columns, allowedMovesFactory);
		this.count = 0;
		if (rows < 8 || columns < 8)
			throw new BoardInitException("Chess board matrix must be 8 x 8");
	}

	@Override
	void initBoard() {
		IntStream.range(0, ROWS).forEach(row -> {
			IntStream.range(0, COLUMNS).forEach(col -> {
				Position position = new Position(row, col);
				position.setId(count);
				positions[count] = position;
				positionMapping.put(position, count);
				adjustment[count] = getAllowedMoves(new Knight(), position);
				count++;

			});
		});

	}

	@Override
	public LinkedList<Position> getAllowedMoves(Piece piece, Position position) {
		return allowedMovesFactory.getAllowedMovesContext(piece).execute(piece, position);

	}

	/**
	 * This is a BFS (Breadth first find calculation) Dijkstra could also been used
	 * but since weight of moves are always the same we keep it simple
	 */
	@Override
	public int calculatePath(Position start, Position end) {
		if (start.equals(end)) {
			return 0;
		}
		Position position = positions[positionMapping.get(start).intValue()];
		boolean[] visited = new boolean[positions.length];
		Queue<Position> q = new LinkedList<>();
		visited[positionMapping.get(start).intValue()] = true;
		q.add(position);
		position.setDistance(0);
		Node node = new Node(position);
		Position prev = position;
		while (!q.isEmpty()) {
			Position p = q.poll();
			node.next = new Node(p);
			if (p.equals(end)) {
				Node current = node;
				while(current!=null) {
					System.out.print(current.position + " > ");
					current = current.next;
				}		
				return p.getDistance();
			}
			LinkedList<Position> pos = adjustment[positionMapping.get(p).intValue()];
			for (Position inner : pos) {
				List<Position> positions = new LinkedList<>();
				positions.add(p);

				if (!visited[positionMapping.get(inner).intValue()]) {
					visited[positionMapping.get(p).intValue()] = true;
					if (inner.equals(end)) {
						node.next.next = new Node(inner);
						p.setDistance(p.getDistance()+1);		
						Node current = node;
						while(current!=null) {
							System.out.print(current.position + " > ");
							current = current.next;
						}
						return p.getDistance();
					}
					inner.setDistance(inner.getDistance()+1);
					q.add(inner);
					
				}
				
			}
			prev = p;
		}
		return -1;

	}


}
