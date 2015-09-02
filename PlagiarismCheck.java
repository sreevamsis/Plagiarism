import java.io.*;
import java.util.*;

class PlagiarismCheck {
  String orginal;
  String duplicate;
  PlagiarismCheck(String orginal, String duplicate) {
      this.orginal = orginal;
      this.duplicate = duplicate;
  }
  private String getFileContent(String file) {
    StringBuffer content = new StringBuffer();
    try {
      File fil = new File(file);
      FileReader filereader = new FileReader(fil);
      BufferedReader br = new BufferedReader(filereader);
      String str;
      while ((str = br.readLine()) != null) {
        content.append(str);
      }
    } catch(Exception e) {
      System.out.println(e);
    }
    return content.toString();
  }
  private int check(String orginal, String duplicate) {
    int count = 0;
    String orginalcontent = getFileContent(orginal);
    String dupcontent = getFileContent(duplicate);
    ArrayList<String> orginalwords = new ArrayList<String>();
    StringTokenizer st = new StringTokenizer(orginalcontent);
    while (st.hasMoreTokens()) {
      orginalwords.add(st.nextToken());
    }
    for (String org : orginalwords) {
      if (dupcontent.contains(org)) {
        count++;
      }
    }
    return count;
  }
  public double percentageMatch(String orginal, String duplicate) {
    String orginalcontent = getFileContent(orginal);
    ArrayList<String> orginalwords = new ArrayList<String>();
    StringTokenizer st = new StringTokenizer(orginalcontent);
    while (st.hasMoreTokens()) {
      orginalwords.add(st.nextToken());
    }
    int count = check(orginal, duplicate);
    double percent = ((double)count * 100)/((double)orginalwords.size());
    return percent;
  }
}