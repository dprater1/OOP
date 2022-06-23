import java.util.*;

public class Set {
    private ArrayList<Integer> list;
    private int capacity;
    private int size;

    public Set(){
        this.list = new ArrayList<>();
        this.capacity = Integer.MAX_VALUE;
        this.size = 0;
    }

    public Set(int capacity){
        this.list = new ArrayList<>();
        this.capacity = capacity;
        this.size = 0;
    }



    public void add(int val){
        if(size == capacity){
            throw new IndexOutOfBoundsException();
        }
        if(list.size() == 0) {
            list.add(val);
            size++;
        }
        int count = 0;
        int min = 0;
        int max = size-1;
        for(int i = 0; i < list.size(); i++){
            int avg = min + (max-min)/2;
            if(list.get(i) == val){
                break;
            }
            if(list.get(avg) > val){
                max = avg - 1;
            }
            if(list.get(avg) < val){
                min = avg + 1;
            }
            count++;
        }
        if(count == list.size()) {
            list.add(val);
            size++;
        }  
    }
        
    public void addAll(ArrayList<Integer> newlist){
        for(int i = 0; i < newlist.size(); i++){
            if(size == capacity){
                throw new IndexOutOfBoundsException();
            }
            if(!list.contains(newlist.get(i))){
                list.add(newlist.get(i));
                size++;
            }
        }

    }

    public void clear(){
        list.removeAll(list);
        size = 0;
    }

    public boolean contains(int val){
        return list.contains(val);
    }
    
    public boolean containsAll(ArrayList<Integer> newlist){
        for(int i = 0; i < newlist.size(); i++){
            if(!list.contains(newlist.get(i))) return false;
        }
        return true;
    }

    public int hashCode(){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void remove(int val){
        if(isEmpty()) throw new NullPointerException();

        for(int i = 0; i < list.size(); i++){
        if(list.get(i) == val) 
        list.remove(list.get(i));
        size--;
        }
    }

    public void removeAll(ArrayList<Integer> newlist){
        if(isEmpty()) throw new NullPointerException();
        
        list.removeAll(newlist);
        size = size - newlist.size();

    }
    

    public void retainAll(ArrayList<Integer> newlist){

        for(int i = 0; i < list.size(); i++){
            if(size == capacity){
                throw new IndexOutOfBoundsException();
            }
            if(!newlist.contains(list.get(i))){
                list.remove(list.get(i));
                size--;
            }
        }
    }

    public int size(){
        return size;
    }
}
