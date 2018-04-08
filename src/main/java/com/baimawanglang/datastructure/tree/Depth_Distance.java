package com.baimawanglang.datastructure.tree;

public class Depth_Distance {
    public int depth;
    public int distance;

    public Depth_Distance() {
        this.depth = 0;
        this.distance = 0;
    }

    public Depth_Distance(int depth, int distance) {
        this.depth = depth;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Depth_Distance{" + "depth=" + depth + ", distance=" + distance + '}';
    }
}
