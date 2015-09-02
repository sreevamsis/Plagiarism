class Plagiarism {
  public static void main(String[] args) {
    String orginalfile = "vamsi.txt.txt";
    String duplicate = "vamsi1.txt.txt";
    PlagiarismCheck check = new PlagiarismCheck(orginalfile, duplicate);
    double percentage = check.percentageMatch(orginalfile, duplicate);
    System.out.printf("%.2f", percentage);
    System.out.print("%");
  }
}