/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dora Sara Robb
 * Created: Nov 6, 2017
 */

CREATE OR REPLACE VIEW MAX_STOCK
as 
SELECT rownum as MAX_STOCK_ID, p.STOCK, p.product_id, p.location_id
FROM product_location_relationship p LEFT OUTER JOIN product_location_relationship pa 
ON p.location_id = pa.location_id AND p.stock < pa.stock 
WHERE pa.product_id IS NULL;