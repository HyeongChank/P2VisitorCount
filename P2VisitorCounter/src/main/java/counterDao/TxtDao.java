package counterDao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtDao {
    
	public void txt(String name, String tel, String ment) {
//		String filePath = "D:\\김형찬\\P2VisitCounter\\P2VisitorCounter\\src\\main\\webapp\\report.txt"; // 저장할 파일 경로 및 이름
//	    File file = new File(filePath);
//	    System.out.println("txt 넘어옴");
//	//true를 붙이면 데이터가 누적해서 쌓임
//	    try {
//	        FileWriter writer = new FileWriter(filePath, true);
//	        writer.write(name + " "+ tel + " "+ ment +  "\n"); // 데이터를 파일에 쓰기
//	        writer.write("\n");
//	        writer.close(); // 파일 쓰기 종료
//	        System.out.println("저장 성공");
//	    }
//	    catch(Exception e) {
//	    	e.printStackTrace();
//	    }
	    
		String filePath = "D:\\김형찬\\P2VisitCounter\\report1.txt";
		File file = new File(filePath);
		System.out.println("txt넘어옴");
		try {
		    if (!file.exists()) {
		        file.createNewFile();
		    }
		    if (!file.canWrite()) {
		        throw new IOException("파일 쓰기가 불가능합니다");
		    }
		    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		    writer.write(name + " " + tel + " " + ment);
		    writer.newLine(); // 중복된 호출 제거
		    writer.flush();
		    System.out.println("파일에 작성 완료");
		    writer.close();
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
