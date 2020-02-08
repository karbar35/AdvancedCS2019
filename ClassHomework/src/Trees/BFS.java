package Trees;

import Trees.Vertex;
import Trees.Edge;
import Trees.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {
	private static Node[] nodes;

	public static void main(String[] args) {
		Scanner s = null;
		try {
			s = new Scanner(new File("BFSTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int N = s.nextInt();
		int M = s.nextInt();
		int X1 = s.nextInt()-1;
		int X2 = s.nextInt()-1;
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}
		for (int j = 0; j < M; j++) {
			// potentially instantiate variables for nextInts here
			int p1 = s.nextInt()-1;
			int p2 = s.nextInt()-1;
			nodes[p1].add(nodes[p2]);
			nodes[p2].add(nodes[p1]);
		}

		ArrayDeque<Node> deck = new ArrayDeque<Node>();
		Node startNode = nodes[X1];

		if (X1 == X2) {
			System.out.println("0");
			return;
		} else {
			boolean[] visited = new boolean[N];
			deck.add(startNode);
			visited[startNode.value] = true;
			while (!deck.isEmpty()) {
				Node t = deck.pop();
				for (Node r : t.children) {
					if (!visited[r.value]) {
						deck.add(r);
						visited[r.value] = true;
						r.setLevel(t.level + 1);
						if (r.value == X2) {
							System.out.println("answer " + r.level);
							return;
						}
					}
				}
			}

		}
	}

	private static class Node {
		int value;
		ArrayList<Node> children;
		int level;

		public Node(int v) {
			value = v;
			children = new ArrayList<Node>();
			level = 0;
		}

		public void add(Node n) {
			children.add(n);
		}

		public void setLevel(int l) {
			level = l;
		}

	}

}
