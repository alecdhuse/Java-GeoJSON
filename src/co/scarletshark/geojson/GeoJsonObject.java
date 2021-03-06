/*
 *    Copyright 2013 Alec Dhuse
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */
package co.scarletshark.geojson;

/**
 * Ancestor class for GeoJsonObjects.
 * 
 * @author Alec Dhuse
 */
public abstract class GeoJsonObject {
    protected JsonCoordinate[] coordinates;
    
    /**
     * Tells if the coordinates in two GeoJsonObjects are equal.
     * 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        boolean          isEqual = false;
        JsonCoordinate[] coordinates;
        
        if (object instanceof GeoJsonObject) {
            coordinates = ((GeoJsonObject) object).getCoordinates();
            
            if (coordinates.length == this.coordinates.length) {
                isEqual = true;
                
                for (int i = 0; i < coordinates.length; i++) {
                    if (coordinates[i].equals(this.coordinates[i])) {
                        isEqual = true;
                    } else {
                        isEqual = false;
                        break;
                    }
                }
            } else {
                isEqual = false;
            }                            
        } else {
            isEqual = false;
        }
        
        return isEqual;
    }
    
    /**
     * Returns the Coordinates being used by this GeoJsonObject.
     * 
     * @return 
     */
    public JsonCoordinate[] getCoordinates() {
        return coordinates;
    }    
    
    /**
     * Returns a String representation of this Object.  
     * The default is a list of coordinates in array format.
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            
        sb.append("[ ");
        
        for (JsonCoordinate c: coordinates) 
            sb.append(c.toString());        
        
        sb.append(" ]");
        
        return sb.toString();
    }
    
    /**
     * Returns a String with a given number of tabs.
     * 
     * @param indent    The number of tabs to return.
     * @return 
     */
    public static String getIndent(int indent) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < indent; i++) 
            sb.append("\t");
        
        return sb.toString();
    }
}
