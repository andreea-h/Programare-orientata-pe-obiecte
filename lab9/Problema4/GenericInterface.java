import java.util.*;

public interface GenericInterface {
	//Sterge duplicatele dintr-o lista si returneaza lista rezultata
	public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list);
	//Determina elementul maxim dintr-o lista
	public <E extends Comparable<E>> E max(ArrayList<E> list);
	//Cauta o valoare in lista sortata, folosind algoritmul de cautare binara si returneaza pozitia
	public <E extends Comparable<E>> int binarySearch(ArrayList<E> list,E key, int start, int end);
}
	

class GenericListMethods implements GenericInterface {
	
	public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> result = new ArrayList<E>();  //lista care contine rezultatul
		for(E iterator : list) {
			if(result.contains(iterator)==false) {
				result.add(iterator);
			}
		}
		return result;
	}
	
	public <E extends Comparable<E>> E max(ArrayList<E> list) {
		return Collections.max(list);
	}
	
	public <E extends Comparable<E>> int binarySearch(ArrayList<E> list,E key, int start, int end) {
		    //conditia de oprire (x nu se afla in v)
		    if (start > end) 
		        return -1;	
		    //etapa divide
		    int mid = (start + end) / 2;
		    //etapa stapaneste
		    E element = list.get(mid);
		    if (element.compareTo(key)==0) 
		        return mid;
		    if (element.compareTo(key)>0) 
		        return binarySearch(list, key,start, mid-1);
		    if (element.compareTo(key)<0) 
		        return binarySearch(list, key,mid+1, end);
		    return 0;
	}
}

