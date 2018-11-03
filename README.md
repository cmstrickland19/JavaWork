#Serialization-Exercise

Task
Add Funcionality to classes used in an existing comuter game. The classes are:
  Player-has int heathPoints and String name
  HealthPack-has an int that sores health packs and the methds:
    public healthPack()
    public HealthPAck(int points)
    public int getHeakthPoints()
    public void sethealthPoints()int points)
   BackPack- has an ArrayList<HealthPack> and the methods
    public BackPAck()
    public void addHealthPack(HealthPack hp)
    public HealthPack useHealthPAck()
    public int getNumPaks()

Wizard needs to extend Player class. Wizard have Shields and Powers.

At any point i time, The wizad can be saved and into a byte stream and stored in a file.
It also can resored from a file and the player can cotinue playing.

Also Note the classes to be implmented to the Wizard class DONOT implements Serializable.
