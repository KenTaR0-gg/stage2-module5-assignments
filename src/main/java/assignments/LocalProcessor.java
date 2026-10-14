package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private long period = 10_000_000_000_000L;
    private String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringList = new LinkedList<>();

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringList = stringList;
    }
    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator (List<String> stringList) {
        int i = 0;
        List<String> list = new ArrayList<>(stringList);
        for (String str : list) {
            if (str == null) throw new NullPointerException();
            if (i >= period) break;
            System.out.println(str.hashCode());
            i++;
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        if (processorName != null) {
            sb.append(processorName);
        }
        for (String string : stringList) {
            sb.append(string);
            sb.append(" ");
        }
        processorName = sb.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        if (processorVersion != null) {
            sb.append(processorVersion);
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        }
        processorVersion = sb.toString();
    }
}
