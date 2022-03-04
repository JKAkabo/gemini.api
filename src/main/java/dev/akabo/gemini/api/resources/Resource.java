package dev.akabo.gemini.api.resources;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Resource {
    private final List<Rel> rels;

    public Resource(List<Rel> rels) {
        this.rels = rels;
    }

    public Optional<Rel> findRel(String key) {
        return this.rels.stream().filter(rel -> rel.getKey().equals(key)).findFirst();
    }

    @Getter
    @Setter
    public static class Rel {
        private String key;
        private List<Rel> children = new ArrayList<>();

        public static List<Rel> parse(List<String> rels_) {
            List<Rel> rels = new ArrayList<>();
            if (rels_ == null) return rels;
            parse(rels, rels_.stream().map(s -> s.split("\\.")).toList());
            return rels;
        }

        private static void parse(List<Rel> rels, List<String[]> rels_) {
            for (String[] rel_ : rels_) {
                Rel rel = null;
                for (Rel r1 : rels) {
                    if (r1.getKey().equals(rel_[0])) {
                        rel = r1;
                        break;
                    }
                }
                if (rel == null) {
                    rel = new Rel();
                    rel.setKey(rel_[0]);
                    rels.add(rel);
                }
                int i = 1;
                while (i < rel_.length) {
                    Rel rel1 = null;
                    for (Rel r : rel.getChildren()) {
                        if (r.getKey().equals(rel_[i])) {
                            rel1 = r;
                            break;
                        }
                    }
                    if (rel1 == null) {
                        rel1 = new Rel();
                        rel1.setKey(rel_[i]);
                        rel.getChildren().add(rel1);
                    }
                    rel = rel1;
                    i++;
                }
            }
        }
    }
}
