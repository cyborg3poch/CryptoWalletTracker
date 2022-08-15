package xyz.epoch.wallettracker.Validation;

import xyz.epoch.wallettracker.Model.WalletDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

public class WalletAddressValidator implements ConstraintValidator<ValidWalletAddress, Object> {
    @Override
    public void initialize(ValidWalletAddress constraintAnnotation) {
      //
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext context) {

        final WalletDTO walletDTO = (WalletDTO) value ;

        return isChecksumAddress(walletDTO.getAddress()) ;
    }

    public boolean isChecksumAddress(String addr)
    {


        // First we need to check the address has the value between 0-9a-fA-F
        String regex = "^0x[0-9a-fA-F]{40}$";
        if(!addr.matches(regex))
        {
            return false;
        }

        //to fetch the part after 0x
        String subAddr = addr.substring(2);
        //Make it to original lower case address
        String subAddrLower = subAddr.toLowerCase();


        // if the previous step validates then we will test the checksum part

        // Create a SHA3256 hash (Keccak-256)
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest256();
        digestSHA3.update(subAddrLower.getBytes());
        String digestMessage = Hex.toHexString(digestSHA3.digest());



        /* Check each letter is upper case or not
         * if it is upper case then the corresponding binary position of the hashed address
         * should be 1 i.e the message digest letter should be getter than 7
         * as 7 is the last Hex digit which starts with 0 in binary
         * rest of all 8 to f starts with 1
         */

        for(short i=0 ;i < subAddr.length();i++)
        {
            if(subAddr.charAt(i)>=65 && subAddr.charAt(i)<=91)
            {

                String ss = Character.toString(digestMessage.charAt(i));
                if(!(Integer.parseInt(ss,16) > 7 ))
                {
                    return false;
                }
            }
        }

        return true;



    }


}
