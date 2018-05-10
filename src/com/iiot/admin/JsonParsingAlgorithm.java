package com.iiot.admin;

/**
 * IIOT 작업 중 당착한 문제 해결하기
 * @author nam
 *
 * JSON 형태로 String을 전달받아서 Parsing하는 과정에서 발생하는 오류 해결하기
 * (JSON value 내에 "(double quotes) 가 있을때 Parsing 오류가 발생)
 * 
 * But, 아래 방법1로 해결 안되는 문제 발생! => 패턴자체가 Json과 유사하여 패턴 찾아 바꾸기 어려움
 * 예시) {"key":"{"inside":"{"AAA"},{"AAA"}","inside2":"["abc","abc"]"}"}
 */
public class JsonParsingAlgorithm {
	public static void main(String[] args) {
		// example1
		//String json = "{\"key\":\"value\",\"key2\":\"val\"u\"\"\"\"e2\'\"\",\"\"key3\":\"value3\"}";
		// example2
		String json = "{\"key\":\"{\"inside\":\"{\"AAA\"},{\"AAA\"}\",\"inside2\":\"[\"abc\",\"abc\"]\"}\"}";
		
		System.out.println("original JSON string :: "+json);
		
		json = changeDoubleQuotesInJson(json);
		
		System.out.println("changed JSON string :: "+json);
	}
	
	/**
	 * 방법1 : json 내부의 따옴표 카운트를 세어, 다음 글자와 비교시킨 후 안쪽의 따옴표를 싱글로 바꾸기
	 * @param json
	 * @return
	 */
	public static String changeDoubleQuotesInJson(String json){
		char[] charAry = json.toCharArray();
		int doubleQuoutesCnt = 0;
		for(int i=1; i<charAry.length-2; i++){
			if(charAry[i] == '\"'){
				doubleQuoutesCnt++;
			}
			if(charAry[i] == '\"' && doubleQuoutesCnt >= 2 && charAry[i+1] != ':' && charAry[i+1] != ',' 
					 && charAry[i+1] != '}'){
				charAry[i] = '\'';
			}
			if(charAry[i+1] == ':' || charAry[i+1] == ',' || charAry[i+1] == '}'){
				doubleQuoutesCnt = 0;
			}
		}
		
		String changedJson = new String(charAry);
		return changedJson;
	}
}
