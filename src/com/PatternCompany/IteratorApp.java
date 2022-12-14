package com.PatternCompany;

public class IteratorApp {
    public static void main(String[] args) {
        Tasks c = new Tasks();
        Iterator it = c.getIterator();

        while (it.hasNext()){
            System.out.println((String) it.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator getIterator();
}

class Tasks implements Container {
    String[] tasks = {"Построить дом", "Родить сына", "Посадить дерево"};

    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            }
            return false;
        }

        public Object next() {
            return tasks[index++];
        }
    }
}
