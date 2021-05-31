import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = Integer.parseInt(in.next());
            int curLink = 0, maxLink = 0;
            Set<String> linkPool = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                String name = in.next(), state = in.next();
                if (!linkPool.contains(name) && "connect".equals(state)) {
                    linkPool.add(name);
                    ++curLink;
                    maxLink = Math.max(curLink, maxLink);
                    continue;
                }

                if (linkPool.contains(name) && "disconnect".equals(state)) {
                    --curLink;
                    linkPool.remove(name);
                }
            }

            System.out.println(maxLink);
        }

        in.close();
    }
}