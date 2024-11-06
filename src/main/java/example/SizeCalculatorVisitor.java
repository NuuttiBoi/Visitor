package example;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }
    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            System.out.println(element);
        }
    }

    public int getTotalSize() {
        return totalSize;
    }
}
