package messj.strengthenchemistry.json;

/**
 * Created by USER on 4/18/2017.
 */

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import messj.strengthenchemistry.bean.Product;

public class JsonReader {

    public static List<Product> getHome(JSONObject jsonObject)
            throws JSONException {
        List<Product> products = new ArrayList<Product>();

        JSONArray jsonArray = jsonObject.getJSONArray(TagName.TAG_PRODUCTS);
        Product product;
        for (int i = 0; i < jsonArray.length(); i++) {
            product = new Product();
            JSONObject productObj = jsonArray.getJSONObject(i);
            product.setId(productObj.getInt(TagName.KEY_ID));
            product.setName(productObj.getString(TagName.KEY_NAME));
            product.setImageUrl(productObj.getString(TagName.KEY_IMAGE_URL));

            products.add(product);
        }
        return products;
    }
}
