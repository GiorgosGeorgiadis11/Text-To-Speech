# Text to Speech (Convert Text to Speech)

The "Text to Speech" project is a Java-based application that enables users to convert written text into speech using the FreeTTS library. This README file provides an overview of the project, including installation instructions, file descriptions and usage guidelines.

## Table of Contents

1. [Introduction](#introduction)
2. [Installation](#installation)
3. [File Descriptions](#file-descriptions)
4. [Usage](#usage)

## Introduction

The Text to Speech project offers a convenient way for users to convert textual content into spoken words. By providing a user-friendly graphical interface, users can input text and have it synthesized into speech. The project utilizes the FreeTTS library, a freely available text-to-speech synthesis system written entirely in Java.

## Installation

To install and run the Text to Speech application, follow these steps:

1. Ensure that Java is installed on your system. You can download Java from the [official website](https://www.java.com/en/download/).(I used JDK 21)
2. Download the source code of the project.
3. FreeTTS library is already downloaded in the lib folder.
4. Run the Text2SpeeechEditorView file, that contains the project main function.
5. If project is not running, you must add the jar files(you can find this files in path: lib/freetts-1.2/lib) of FreeTTS library in project External Libraries. 

## File Descriptions

The project consists of the following files:

1. **Text2SpeechEditorView.java**: The main file of the program containing the graphical user interface (UI) and initialization logic.
2. **CommandsFactory.java**: The factory class responsible for creating ActionListener objects based on user commands.
3. **NewDocument.java**: Class for creating a new document.
4. **EditDocument.java**: Class for editing an existing document.
5. **SaveDocument.java**: Class for saving a document to disk.
6. **OpenDocument.java**: Class for opening an existing document.
7. **LineToSpeech.java**: Class for converting text to speech.
8. **TuneEncoding.java**: Class for tuning the encoding of a document.
9. **TuneAudio.java**: Class for tuning the audio settings for text-to-speech conversion.

## Usage

Once the program is installed and running, follow these steps to use it:

1. Launch the application.
2. Select from menu, New Document if you want to create new file or Open Document if you want to use an existing file.
3. Input the desired text into the text input field.
4. Select the appropriate command:
    * speech: To read all the text backward
    * Reversed speech: To read all the text 
    * Line to speech: To read the selected line
    * Reversed line to speech: To read the selected line backward
    * Encoding: To read the file based on the encoding you selected(Atbash, Rot-13)
5. Optionally, adjust any audio settings before converting text to speech from Menu->Audio Tune.
