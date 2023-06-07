package com.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.practice.list.music.moel.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList();
	
	public MusicController() {//리스트에 초기 곡 추가
		list.add(new Music("aa", "aaa"));
		list.add(new Music("bb", "bbb"));
		list.add(new Music("cc", "ccc"));
		list.add(new Music("dd", "ddd"));
		list.add(new Music("aa", "eee"));
		list.add(new Music("bb", "fff"));
	}

	public int addList(Music music) {	//0:추가실패, 1:추가성공
		int result = 0;
		if(list.add(music)) { //list.add 에서 f2 > boolean add(E e);
			result = 1;	//boolean list.add(music) 참이면 1
		}
		return result;
	}
	public int addAtZero(Music music) {	//0:추가실패, 1:추가성공
		int result = 0;
		int cnt = list.size();
		((ArrayList<Music>)list).add(0, music);	
							   //add 가 void > public void add(int index, E element) >boolean 불가능
		int cntAfter = list.size();
		if(cnt<cntAfter) {
			result = cntAfter-cnt;
		}
		return result;
		
		
	}
	public List<Music> printAll() {
		return list;
		//TODO
	}
	public Music searchMusic(String title) {//검색을 어떻게? 필드 list로부터.
		Music result = null;
		for(Music vo : list) {
//			if(vo.equals(title)) {	//title은 스트링. vo는 뮤직 >> 자료형이 안맞음. >> equals 비교 불가
			if(vo.getTitle().equals(title)) { 
				result = vo;		//title 똑같은 vo 찾았다.
				break;				//더 볼 필요 없다. > 더 반복하지 않는다.
			}
		}//if 문 안에 맞는게 없으면 result 에는 null이 간다.
		return result;
	}
	public Music removeMusic(String title) {
		Music result = null;
		//TODO
		return result;
	}
	public Music setMusic(String title, Music music) {
		Music result = null;
		//TODO
		return result;
	}
	public int ascTitle() {
		int result = 0;
		//TODO
		return result;
	}
	public int descSinger() {
		int result = 0;
		//TODO
		return result;
	}
}
