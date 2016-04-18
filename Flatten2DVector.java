public class Flatten2DVector {
    Iterator<Iterator<Integer>> iters;
    Iterator<Integer> itNow;
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null || vec2d.size() == 0)
            return;
        List<Iterator<Integer>> list = new ArrayList();
        for (List<Integer> l : vec2d) {
            if (l.size() > 0) 
                list.add(l.iterator());
        }
        iters = list.iterator();
    }

    public int next() {
        return itNow.next();
    }

    public boolean hasNext() {
        if (iters == null) return false; //这里忘记了；
        if (itNow == null && iters.hasNext())
            itNow = iters.next();
        if (itNow == null)
            return false;
        if (itNow.hasNext())
            return true;
        if (iters.hasNext()) {
            itNow = iters.next();
            return true;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */