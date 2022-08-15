package xyz.epoch.wallettracker.APIClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import xyz.epoch.wallettracker.Model.APIListResponseModel;
import xyz.epoch.wallettracker.Model.APIStringResponseModel;
import xyz.epoch.wallettracker.Model.TransactionDTO;

import java.util.HashMap;

@Repository
@PropertySource("classpath:application.properties")
public class RestClientService {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private APIListResponseModel APIListResponseModel;

    @Autowired
    private APIStringResponseModel APIStringResponseModel;

    @Value("${EthScanApiUrlMainNet}")
    private   String ETH_API_ENDPOINT;

    @Value("${EthScanApiKey}")
    private String ETH_API_KEYS;

    @Value("${PolyScanApiUrlMainNet}")
    private   String POLY_API_ENDPOINT;

    @Value("${PolyScanApiKey}")
    private String POLY_API_KEYS;



    public String getAPIUrl(String chain)
    {


        if(chain.equals("ETH"))
        {
            return  ETH_API_ENDPOINT;

        }else
        {
            return POLY_API_ENDPOINT;

        }
    }

    public String getAPIKeys(String chain)
    {


        if(chain.equals("ETH"))
        {
            return  ETH_API_KEYS;

        }else
        {
            return POLY_API_KEYS;

        }
    }

    public TransactionDTO[] getWalletAccountDetails(String walletAddress , long trackedBlockNo , long currentBlock , String chain)
    {


        try{
            APIListResponseModel = restTemplate.getForObject(getAPIUrl(chain)+"/?module=account" +
                     "&action=txlist&address="+walletAddress+"" +
                     "&startblock="+trackedBlockNo+"&" +
                     "endblock="+currentBlock+"&apikey="+getAPIKeys(chain), APIListResponseModel.class );

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }



        return APIListResponseModel.getResult();
    }

    public String getCurrentBlockNumber( String chain)
    {
        long currentUnixTime = System.currentTimeMillis() / 1000L;

        try{
            APIStringResponseModel = restTemplate.getForObject(getAPIUrl(chain)+"/?module=block" +
                    "&action=getblocknobytime" +
                    "&timestamp="+currentUnixTime+
                    "&closest=before" +
                    "&apikey="+getAPIKeys(chain), APIStringResponseModel.class );

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }


        return APIStringResponseModel.getResult();
    }
}
