package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.controller.ArticleController;
import com.KoreaIT.java.AM.controller.MemberController;
import com.KoreaIT.java.AM.Article.Article;
import com.KoreaIT.java.AM.Article.Member;
import com.KoreaIT.java.AM.Util.Util;

public class App {
	
	public static List<Article> articles;
	public static List<Member> members;
	
	static {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}
	
	public void run() {
		System.out.println("== 프로그램 시작 ==");
				
		makeTestData();

		Scanner sc = new Scanner(System.in);
		
		MemberController memberController = new MemberController(members, sc);
		ArticleController articleController = new ArticleController(articles, sc);
		
		while(true) {
			System.out.printf("명령어	: ");
			String cmd = sc.nextLine().trim();
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if (cmd.equals("system exit")) {
				break;
			}
			
			if (cmd.equals("sign up")) {
				memberController.doJoin();
			}
			
			else if(cmd.equals("article list")) {
				articleController.dolist();
			}
			
			else if(cmd.equals("article write")) {
				articleController.dowrite();
			}
			
			else if(cmd.startsWith("article detail")) {
				articleController.dodetail();
			}
			
			else if(cmd.startsWith("article delete")) {
				articleController.dodelete();
			}
			
			else if(cmd.startsWith("article modify")) {
				articleController.domodify();
			}

			else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}
		System.out.println("== 프로그램 종료 ==");
		sc.close();
	}
	
	public static void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");
		for(int i = 1; i <= 3; ++i) {
			articles.add(new Article(i, Util.NowDate(), "t_t_" + i, "t_c_" + i, 0));
		}
	}
}