import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java21NewFeaturesTest18 {

        public static void main(String[] args) throws IOException, InterruptedException {
                String[] command = { "ls", "-l", "/tmp" };

                Process process = Runtime.getRuntime().exec(command);

                process.waitFor();

                showExecutedResult(process);
        }

        private static void showExecutedResult(Process process) throws IOException {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                        String line = null;

                        while ((line = br.readLine()) != null) {
                                System.out.println(line);
                        }
                }
        }
}
/**
 * Output:
        total 76
        drwx------ 2 ovo  ovo  4096 Mar 11 08:28 com.google.Chrome.CSHgGi
        drwxr-xr-x 2 ovo  ovo  4096 Mar 11 09:05 hsperfdata_ovo
        drwx------ 2 ovo  ovo  4096 Mar 11 08:56 mcp-T3iinl
        drwx------ 2 ovo  ovo  4096 Mar 11 08:57 pyright-8680-YUXr0FWp9OTb
        drwxrwxr-x 3 ovo  ovo  4096 Mar 11 08:57 python-languageserver-cancellation
        drwx------ 4 root root 4096 Mar 11 09:00 snap-private-tmp
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-bluetooth.service-yNoiYE
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-colord.service-IYVnUw
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-ModemManager.service-I4W7xt
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-polkit.service-Uf4auL
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-power-profiles-daemon.service-oUQVvO
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-switcheroo-control.service-ewcfhp
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-logind.service-4m6KFb
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-oomd.service-VPurMT
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-resolved.service-RAxU5c
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-timesyncd.service-WpoytK
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-upower.service-CzQ3o8
        drwxrwxrwt 2 root root 4096 Mar 11 08:25 VMwareDnD
        drwx------ 2 root root 4096 Mar 11 08:25 vmware-root_836-2722107930
 */