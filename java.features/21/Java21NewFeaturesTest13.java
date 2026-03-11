import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest13 {

        public static void main(String[] args) throws IOException, InterruptedException {
                List<String> command = new ArrayList<String>() {
                        {
                                add("ls");
                                add("-l");
                                add("/tmp");
                        }
                };

                ProcessBuilder builder = new ProcessBuilder(command);

                System.out.println("command to be executed : " + builder.command());

                builder.inheritIO();

                Process process = builder.start();

                process.waitFor();
        }
}
/**
 * Output:
        command to be executed : [ls, -l, /tmp]
        total 76
        drwx------ 2 ovo  ovo  4096 Mar 11 08:28 com.google.Chrome.CSHgGi
        drwxr-xr-x 2 ovo  ovo  4096 Mar 11 08:58 hsperfdata_ovo
        drwx------ 2 ovo  ovo  4096 Mar 11 08:56 mcp-T3iinl
        drwx------ 2 ovo  ovo  4096 Mar 11 08:57 pyright-8680-YUXr0FWp9OTb
        drwxrwxr-x 3 ovo  ovo  4096 Mar 11 08:57 python-languageserver-cancellation
        drwx------ 3 root root 4096 Mar 11 08:25 snap-private-tmp
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