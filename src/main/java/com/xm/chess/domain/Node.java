package com.xm.chess.domain;

public class Node {
	public Node next;
	public Position position;
	public Node(Position position) {
		this.position = position;
	}

}
