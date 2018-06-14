package com.util.stack;

public class ArrayStack {
	private int size;
	private int top;
	private Data[] dataAry;
	
	public ArrayStack(int size){
		this.size=size;
		this.top=-1;
		this.dataAry = new Data[size];
	}
	
	public boolean pushStack(Data data){
		if(this.top+1>=size){
			System.out.println("더 이상 스택을 추가할 수 없습니다!");
			return false;
		}
		
		top++;
		this.dataAry[top]=data;
		System.out.println(this.dataAry[top].getIntData()+" 데이터를 추가했습니다.");
		return true;
	}
	
	public Data popStack(){
		if(top==-1){
			System.out.println("스택에 저장된 데이터가 없습니다!");
			return null;
		}
		
		Data res = this.dataAry[top];
		this.dataAry[top]=null;
		top--;
		
		System.out.println(res.getIntData()+" 데이터를 추출했습니다.");
		return res;
	}
	
	public boolean clearStack(){
		if(top==-1){
			System.out.println("스택에 저장된 데이터가 없습니다!");
			return false;
		}
		
		while(top!=-1){
			System.out.println(this.dataAry[top].getIntData()+" 데이터를 추출했습니다.");
			this.dataAry[top]=null;
			top--;
		}
		
		return true;
	}
	
	public void printStack(){
		if(top == -1){
			System.out.println("스택에 저장된 데이터가 없습니다!");
			return;
		}
		
		int cnt = top;
				
		while(cnt!=-1){
			System.out.println(cnt+"번째 방에 저장된 데이터 : "+this.dataAry[cnt]);
			cnt--;
		}
		
	}
	
}
