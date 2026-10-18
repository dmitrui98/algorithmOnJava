package lesson3;

import common.data.structure.queue.LinkedListQueue;
import common.data.structure.util.base.QueueInterface;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;

/**
 * Упражнение 1.3.43
 * Список файлов
 */
public class B19_FileList {
    public static void main(String[] args) {
        QueueInterface<FileIndent> queue = new LinkedListQueue<>();
        File rootFolder = new File("data");
        queue.enqueue(new FileIndent(rootFolder, 0));
        StdOut.println(rootFolder.getAbsolutePath());
        while (!queue.isEmpty()) {
            FileIndent folder = queue.dequeue();
            int currentIndent = folder.indent;
            File currentFile = folder.file;
            StdOut.println(" ".repeat(currentIndent) + currentFile.getName());
            for (File file : currentFile.listFiles()) {
                if (file.isDirectory()) {
                    queue.enqueue(new FileIndent(file, currentIndent + 1));
                } else {
                    StdOut.println(" ".repeat(currentIndent + 1) + file.getName());
                }
            }
        }
    }

    private static class FileIndent {
        private File file;
        private int indent;

        public FileIndent(File file, int indent) {
            this.file = file;
            this.indent = indent;
        }
    }
}
