package example;

public class Main {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("document.txt", 2);
        File file2 = new File("photo.jpg", 5);
        File file3 = new File("video.mp4", 50);

        // Create directories and add files to them
        Directory root = new Directory("root");
        Directory images = new Directory("images");
        Directory videos = new Directory("videos");

        root.addElement(file1);
        images.addElement(file2);
        videos.addElement(file3);

        root.addElement(images);
        root.addElement(videos);

        // Use SizeCalculatorVisitor to calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        // Use SearchVisitor to find files with .jpg extension
        SearchVisitor searchVisitor = new SearchVisitor(".jpg");
        root.accept(searchVisitor);
        System.out.println("Matching files for '.jpg' extension:");
        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println(" - " + file.getName());
        }
    }
}