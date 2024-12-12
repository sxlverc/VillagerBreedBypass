# VillagerBreedBypass

VillagerBreedBypass is a Minecraft plugin that allows villagers to pick up food and breed even when the `mobGriefing` gamerule is turned off.

## Features

- Villagers can pick up food items (bread, carrots, potatoes, beetroots) even when `mobGriefing` is off.
- Prevents the trading window from opening when right-clicking a villager while holding food.
- Plays a sound when a villager picks up food.

## Installation

1. Download the plugin JAR file.
2. Place the JAR file in the `plugins` folder of your Minecraft server.
3. Start or restart your server.

## Usage

Simply right-click a villager with a food item (bread, carrot, potato, beetroot) to give it to the villager. The villager will pick up the food and the trading window will not open.

## Configuration

No additional configuration is required. The plugin works out of the box.

## Development

### Prerequisites

- Java 17 or higher
- Maven

### Building

To build the plugin from source, run the following command:

```sh
mvn clean package
```
The compiled JAR file will be located in the target directory.