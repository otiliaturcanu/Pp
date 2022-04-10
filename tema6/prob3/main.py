import os.path as path


class AudioFile:
    def __init__(self, filename):
        if not filename.endswith(self.ext):
            raise Exception("Format nesuportat")
        self.filename = filename


class MP3File(AudioFile):
    ext = "mp3"

    def play(self):
        print("Se canta {} un mp3".format(self.filename))


class WavFile(AudioFile):
    ext = "wav"

    def play(self):
        print("Se canta {} un wav".format(self.filename))


class OggFile(AudioFile):
    ext = "ogg"

    def play(self):
        print("Se canta {} un ogg".format(self.filename))


class FlacFile:
    def __init__(self, filename):
        if not filename.endswith(".flac"):
            raise Exception("Format nesuportat")
        self.filename = filename

    def play(self):
        print("Se canta {} un flac".format(self.filename))




if __name__ == '__main__':
    file = input('file = ')

    if not path.exists(file):
        raise Exception("Nu exista fisierul")
        exit(1)

    try:
        mp3 = MP3File(file)
        mp3.play()
    except:
        try:
            wav = WavFile(file)
            wav.play()
        except:
            try:
                ogg = OggFile(file)
                ogg.play()
            except:
                try:
                    flac = FlacFile(file)
                    flac.play()
                except:
                    print("Fisierul nu este un fisier audio")
    finally:
        print("Programul s-a terminat")
        exit(0)