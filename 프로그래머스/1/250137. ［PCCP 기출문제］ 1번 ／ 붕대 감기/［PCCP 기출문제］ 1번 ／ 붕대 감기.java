class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castingTime = bandage[0]; 
        int healPerSec = bandage[1];  
        int bonusHeal = bandage[2];   

        int maxHealth = health;       
        int currentHealth = health;   

        int attackIdx = 0;            
        int successCount = 0;         

        int lastAttackTime = attacks[attacks.length - 1][0];

        for (int time = 1; time <= lastAttackTime; time++) {
            boolean attacked = false;
            if (attackIdx < attacks.length && attacks[attackIdx][0] == time) {
                attacked = true;
                int damage = attacks[attackIdx][1];
                currentHealth -= damage; 
                successCount = 0;        
                attackIdx++;             

                if (currentHealth <= 0) {
                    return -1;
                }
            }

            if (!attacked) {
                successCount++; 
                currentHealth += healPerSec; 

                if (successCount == castingTime) {
                    currentHealth += bonusHeal;
                    successCount = 0; 
                }

                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }
        return currentHealth;
    }
}