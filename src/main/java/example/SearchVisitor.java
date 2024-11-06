package example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchVisitor implements FileSystemVisitor {
    private String extension;
    private List<File> matchingFiles = new ArrayList<>();
    private Set<File> visitedFiles = new HashSet<>();


    public SearchVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            matchingFiles.add(file);
            visitedFiles.add(file);
        }
    }
    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            System.out.println(element);
        }
    }


    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
