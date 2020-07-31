package shellchain.command;

import com.ustb.shellchain.command.ShellChainCommand;
import com.ustb.shellchain.object.BalanceAssetBase;
import com.ustb.shellchain.object.formatters.HexFormatter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WalletCommandTest {

    @Test
    public void testExecuteSendWithMetaData(){
        ShellChainCommand shellChainCommand = new ShellChainCommand(TestConst.MULTICHAIN_SERVER_IP,
                TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
        try {
            String address = "1FdeHFyTjDuWc8Xp3QELmSbWx1Y9FH31yR4xkK";
            double amount = 125 ;
            String hexMetaData = "e4b880e6aca1e4baa4e69893e5b09de8af95";
            String name = "asset1" ;
            String str = "";
            double qty = 100;
            String comment = null;
            BalanceAssetBase balanceAssetBase = new BalanceAssetBase();
            balanceAssetBase.setName(name);
            balanceAssetBase.setQty(qty);
            balanceAssetBase.setComment(comment);
            List<BalanceAssetBase> assets = new ArrayList<>();
            assets.add(balanceAssetBase);
          //  str= shellChainCommand.getWalletTransactionCommand().sendWithDataFrom("1Y2bX9g69AG68VDkHXJt2ak3KSsa71wxkrNn2Z",address,"asset1",10,hexMetaData);
            str=shellChainCommand.getWalletTransactionCommand().sendWithMetaData(address,assets, HexFormatter.toHex(hexMetaData));
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
