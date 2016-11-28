package com.bwei.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	static int [] arr={1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// writeObjectToFile("д��һ�仰������");//д��
		// readObjectFromFile();//��ȡ
		
		//System.out.println(dg(5));//�ݹ�
		
		System.out.println("���ҵ��� :"+seach(arr,7));//���ַ�
	}

	// д���ļ���������
	public static void writeObjectToFile(Object obj) {
		File file = new File("test.dat");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(obj);// д��
			objOut.flush();
			objOut.close();
			System.out.println("д��ɹ���");
		} catch (IOException e) {
			System.out.println("д��ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	// ��ȡ�ļ�����
	public static Object readObjectFromFile() {
		Object temp = null;
		File file = new File("test.dat");
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			temp = objIn.readObject();// ��ȡ
			objIn.close();
			System.out.println("��ȡ�ɹ�!");
			System.out.println(temp);
		} catch (IOException e) {
			System.out.println("��ȡʧ�ܣ�");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * �ݹ�
	 */
	static int dg(int i) { /* ������� */
		int sum;
		if (i == 1) { /* �������� */
			return 1;
		} else {
			sum = i + dg(i - 1); /* 1~100�ĺ͵ı���ʽ */
			return sum;/* ���ؽ�� */
		} 
	}
	/**
	 * ���ַ�
	 */
private static int seach(int[] arr, int i) {
		
		int start=0;
		int end=arr.length-1;
		//�ö��ַ����ҵ����ݱ������ź���� ���ֻҪ�Ƚ�һ��Ԫ�غ����һ��Ԫ�ؾͿ���ȷ�������ҵ������Ƿ���������
	if (i<arr[start]||i>arr[end]||start>end) {
		return -1;
	}
	while(start<=end){
		//����е���ֵ
		int mid=(start+end)/2;
		//������ҵ�����С���е��λ�õ�����,��Ѳ��ҵĽ���λ�ö������е�
		if (i<arr[mid]) {
			end=mid-1;
		}else if (i>arr[mid]) {//������ҵ����ݴ����е��λ�õ�����,��Ѳ��ҵ���ʼλ�ö������е�
			start=mid+1;
		}else{//���ز��ҵ�����
			return mid;
		}
	}
		return -1;
	}
}