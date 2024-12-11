package prog4;

import java.util.*;

public class Magic_Star_Intensity {
    
    static class Line {
        int x1, y1, x2, y2;
        
        boolean vertical() {
            return x1 == x2;
        }

        boolean horizontal() {
            return y1 == y2;
        }

        boolean diagonal() {
            return Math.abs(x2 - x1) == Math.abs(y2 - y1);
        }
    }

    static long calculateDistance(int x1, int y1, int x2, int y2) {
        if (x1 == x2) return Math.abs(y1 - y2);
        if (y1 == y2) return Math.abs(x1 - x2);
        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) return Math.abs(x1 - x2);
        return 0;
    }

    static void addLineToMap(Line line, int idx, Map<Pair<Integer, Integer>, List<Integer>> ptsMap) {
        int x1 = line.x1, y1 = line.y1;
        int x2 = line.x2, y2 = line.y2;

        if (line.vertical()) {
            int yStart = Math.min(y1, y2);
            int yEnd = Math.max(y1, y2);
            for (int y = yStart; y <= yEnd; y++) {
                ptsMap.computeIfAbsent(new Pair<>(x1, y), k -> new ArrayList<>()).add(idx);
            }
        } else if (line.horizontal()) {
            int xStart = Math.min(x1, x2);
            int xEnd = Math.max(x1, x2);
            for (int x = xStart; x <= xEnd; x++) {
                ptsMap.computeIfAbsent(new Pair<>(x, y1), k -> new ArrayList<>()).add(idx);
            }
        } else if (line.diagonal()) {
            int steps = Math.abs(x2 - x1);
            int dx = (x2 - x1) / steps;
            int dy = (y2 - y1) / steps;
            for (int i = 0; i <= steps; i++) {
                int x = x1 + i * dx;
                int y = y1 + i * dy;
                ptsMap.computeIfAbsent(new Pair<>(x, y), k -> new ArrayList<>()).add(idx);
            }
        }
    }

    static long solveForPoint(Pair<Integer, Integer> pt, List<Integer> lst, List<Line> lines) {
        List<Long> d = new ArrayList<>();
        for (int lIdx : lst) {
            Line ln = lines.get(lIdx);
            boolean oneSided = (pt.getKey() == ln.x1 && pt.getValue() == ln.y1) ||
                               (pt.getKey() == ln.x2 && pt.getValue() == ln.y2);
            if (oneSided) {
                int ex = (pt.getKey() == ln.x1 && pt.getValue() == ln.y1) ? ln.x2 : ln.x1;
                int ey = (pt.getKey() == ln.x1 && pt.getValue() == ln.y1) ? ln.y2 : ln.y1;
                d.add(calculateDistance(pt.getKey(), pt.getValue(), ex, ey));
            } else {
                d.add(calculateDistance(pt.getKey(), pt.getValue(), ln.x1, ln.y1));
                d.add(calculateDistance(pt.getKey(), pt.getValue(), ln.x2, ln.y2));
            }
        }
        return d.isEmpty() ? 0 : Collections.min(d);
    }

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Line> lines = new ArrayList<>();
        Map<Pair<Integer, Integer>, List<Integer>> ptsMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Line line = new Line();
            line.x1 = sc.nextInt();
            line.y1 = sc.nextInt();
            line.x2 = sc.nextInt();
            line.y2 = sc.nextInt();
            lines.add(line);
            addLineToMap(line, i, ptsMap);
        }

        int K = sc.nextInt();
        long total = 0;
        
        for (Map.Entry<Pair<Integer, Integer>, List<Integer>> entry : ptsMap.entrySet()) {
            Pair<Integer, Integer> pt = entry.getKey();
            List<Integer> lst = entry.getValue();
            if (lst.size() == K) {
                total += solveForPoint(pt, lst, lines);
            }
        }

        System.out.println(total);
        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

